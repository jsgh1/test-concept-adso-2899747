const API_BASE = 'http://localhost:8080/api';

const entities = {
    products: {
        endpoint: 'products',
        fields: ['name', 'price', 'description'],
        display: (item) => `${item.name} - $${item.price}`
    },
    inventory: {
        endpoint: 'inventory-items',
        fields: ['name', 'quantity', 'unitPrice'],
        display: (item) => `${item.name} - Cant: ${item.quantity}`
    },
    suppliers: {
        endpoint: 'suppliers',
        fields: ['name', 'contactInfo'],
        display: (item) => `${item.name} - ${item.contactInfo}`
    },
    categories: {
        endpoint: 'categories',
        fields: ['name', 'description'],
        display: (item) => item.name
    },
    'payment-methods': {
        endpoint: 'payment-methods',
        fields: ['name', 'description'],
        display: (item) => item.name
    },
    roles: {
        endpoint: 'roles',
        fields: ['name', 'description'],
        display: (item) => item.name
    },
    promotions: {
        endpoint: 'promotions',
        fields: ['name', 'discount', 'startDate', 'endDate'],
        display: (item) => `${item.name} - ${item.discount}%`
    },
    users: {
        endpoint: 'users',
        fields: ['username', 'email', 'password', 'roleId'],
        display: (item) => `${item.username} - ${item.email}`
    },
    tables: {
        endpoint: 'cafe-tables',
        fields: ['number', 'capacity'],
        display: (item) => `Mesa ${item.number} - Cap: ${item.capacity}`
    },
    ingredients: {
        endpoint: 'ingredients',
        fields: ['name', 'unit'],
        display: (item) => item.name
    },
    'product-ingredients': {
        endpoint: 'product-ingredients',
        fields: ['productId', 'ingredientId', 'quantity'],
        display: (item) => `Prod: ${item.productId} - Ing: ${item.ingredientId}`
    }
};

let currentEntity = '';
let currentItem = null;

function showSection(sectionId) {
    const sections = document.querySelectorAll('.section');
    sections.forEach(section => section.classList.add('d-none'));
    document.getElementById(sectionId).classList.remove('d-none');
}

async function loadEntity(entityKey) {
    const entity = entities[entityKey];
    try {
        const response = await fetch(`${API_BASE}/${entity.endpoint}`);
        const data = await response.json();
        displayEntity(entityKey, data.data || data);
    } catch (error) {
        console.error(`Error loading ${entityKey}:`, error);
        document.getElementById(`${entityKey}-list`).innerHTML = `<p>Error al cargar ${entityKey}</p>`;
    }
}

function displayEntity(entityKey, items) {
    const container = document.getElementById(`${entityKey}-list`);
    if (items.length === 0) {
        container.innerHTML = `<p>No hay ${entityKey} disponibles</p>`;
        return;
    }
    container.innerHTML = items.map(item => `
        <div class="col-md-4 mb-3">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${entities[entityKey].display(item)}</h5>
                    <button class="btn btn-warning btn-sm me-2" onclick="editEntity('${entityKey}', ${item.id})">Editar</button>
                    <button class="btn btn-danger btn-sm" onclick="deleteEntity('${entityKey}', ${item.id})">Eliminar</button>
                </div>
            </div>
        </div>
    `).join('');
}

function openCreateModal(entityKey) {
    currentEntity = entityKey;
    currentItem = null;
    document.getElementById('modalTitle').textContent = `Crear ${entityKey}`;
    buildForm(entityKey);
    new bootstrap.Modal(document.getElementById('entityModal')).show();
}

function editEntity(entityKey, id) {
    currentEntity = entityKey;
    // Fetch item details (assuming GET /api/{entity}/{id})
    fetch(`${API_BASE}/${entities[entityKey].endpoint}/${id}`)
        .then(response => response.json())
        .then(data => {
            currentItem = data;
            document.getElementById('modalTitle').textContent = `Editar ${entityKey}`;
            buildForm(entityKey, data);
            new bootstrap.Modal(document.getElementById('entityModal')).show();
        });
}

function buildForm(entityKey, data = {}) {
    const form = document.getElementById('entityForm');
    form.innerHTML = entities[entityKey].fields.map(field => `
        <div class="mb-3">
            <label for="${field}" class="form-label">${field.charAt(0).toUpperCase() + field.slice(1)}</label>
            <input type="${field.includes('Date') ? 'date' : field === 'password' ? 'password' : 'text'}"
                   class="form-control" id="${field}" value="${data[field] || ''}" required>
        </div>
    `).join('');
}

function saveEntity() {
    const formData = {};
    entities[currentEntity].fields.forEach(field => {
        formData[field] = document.getElementById(field).value;
    });

    const method = currentItem ? 'PUT' : 'POST';
    const url = currentItem ? `${API_BASE}/${entities[currentEntity].endpoint}/${currentItem.id}` : `${API_BASE}/${entities[currentEntity].endpoint}`;

    fetch(url, {
        method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(() => {
        bootstrap.Modal.getInstance(document.getElementById('entityModal')).hide();
        loadEntity(currentEntity);
    })
    .catch(error => console.error('Error saving:', error));
}

function deleteEntity(entityKey, id) {
    if (confirm('¿Estás seguro de eliminar este elemento?')) {
        fetch(`${API_BASE}/${entities[entityKey].endpoint}/${id}`, { method: 'DELETE' })
        .then(() => loadEntity(entityKey))
        .catch(error => console.error('Error deleting:', error));
    }
}

// Specific load functions
function loadProducts() { loadEntity('products'); }
function loadInventory() { loadEntity('inventory'); }
function loadSuppliers() { loadEntity('suppliers'); }
function loadCategories() { loadEntity('categories'); }
function loadPaymentMethods() { loadEntity('payment-methods'); }
function loadRoles() { loadEntity('roles'); }
function loadPromotions() { loadEntity('promotions'); }
function loadUsers() { loadEntity('users'); }
function loadTables() { loadEntity('tables'); }
function loadIngredients() { loadEntity('ingredients'); }
function loadProductIngredients() { loadEntity('product-ingredients'); }

// Load products by default
document.addEventListener('DOMContentLoaded', () => {
    showSection('products');
    loadProducts();
});