const API_BASE = 'http://localhost:8080/api';

function showSection(sectionId) {
    const sections = document.querySelectorAll('.section');
    sections.forEach(section => section.classList.add('d-none'));
    document.getElementById(sectionId).classList.remove('d-none');
}

async function loadProducts() {
    try {
        const response = await fetch(`${API_BASE}/products`);
        const data = await response.json();
        displayProducts(data.data || data);
    } catch (error) {
        console.error('Error loading products:', error);
        document.getElementById('products-list').innerHTML = '<p>Error al cargar productos</p>';
    }
}

function displayProducts(products) {
    const container = document.getElementById('products-list');
    if (products.length === 0) {
        container.innerHTML = '<p>No hay productos disponibles</p>';
        return;
    }
    container.innerHTML = products.map(product => `
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${product.name}</h5>
                <p class="card-text">Precio: $${product.price}</p>
                <p class="card-text">Descripción: ${product.description || 'Sin descripción'}</p>
            </div>
        </div>
    `).join('');
}

async function loadInventory() {
    try {
        const response = await fetch(`${API_BASE}/inventory-items`);
        const data = await response.json();
        displayInventory(data.data || data);
    } catch (error) {
        console.error('Error loading inventory:', error);
        document.getElementById('inventory-list').innerHTML = '<p>Error al cargar inventario</p>';
    }
}

function displayInventory(items) {
    const container = document.getElementById('inventory-list');
    if (items.length === 0) {
        container.innerHTML = '<p>No hay items en inventario</p>';
        return;
    }
    container.innerHTML = items.map(item => `
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${item.name}</h5>
                <p class="card-text">Cantidad: ${item.quantity}</p>
                <p class="card-text">Precio unitario: $${item.unitPrice}</p>
            </div>
        </div>
    `).join('');
}

async function loadCategories() {
    try {
        const response = await fetch(`${API_BASE}/categories`);
        const data = await response.json();
        displayCategories(data.data || data);
    } catch (error) {
        console.error('Error loading categories:', error);
        document.getElementById('categories-list').innerHTML = '<p>Error al cargar categorías</p>';
    }
}

function displayCategories(categories) {
    const container = document.getElementById('categories-list');
    if (categories.length === 0) {
        container.innerHTML = '<p>No hay categorías disponibles</p>';
        return;
    }
    container.innerHTML = categories.map(category => `
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${category.name}</h5>
                <p class="card-text">Descripción: ${category.description || 'Sin descripción'}</p>
            </div>
        </div>
    `).join('');
}

// Load products by default
document.addEventListener('DOMContentLoaded', () => {
    showSection('products');
    loadProducts();
});