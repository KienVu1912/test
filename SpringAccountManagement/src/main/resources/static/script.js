function fetchAccounts() {
    fetch('/api/accounts')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById('accountTableBody');
            tableBody.innerHTML = '';
            data.forEach(account => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${account.id}</td>
                    <td>${account.username}</td>
                    <td>${account.password}</td>
                    <td class="action-buttons">
                        <button onclick="editAccount(${account.id}, '${account.username}', '${account.password}')">Edit</button>
                        <button class="delete" onclick="deleteAccount(${account.id})">Delete</button>
                    </td>
                `;
                tableBody.appendChild(row);
            });
        });
}

function addOrUpdateAccount() {
    const id = document.getElementById('accountId').value;
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const account = { username, password };

    const method = id ? 'PUT' : 'POST';
    const url = id ? `/api/accounts/${id}` : '/api/accounts';

    fetch(url, {
        method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(account)
    }).then(response => {
        if (response.ok) {
            fetchAccounts();
            clearForm();
        } else {
            alert('Error saving account');
        }
    });
}

function editAccount(id, username, password) {
    document.getElementById('accountId').value = id;
    document.getElementById('username').value = username;
    document.getElementById('password').value = password;
}

function deleteAccount(id) {
    if (confirm('Are you sure you want to delete this account?')) {
        fetch(`/api/accounts/${id}`, { method: 'DELETE' })
            .then(response => {
                if (response.ok) {
                    fetchAccounts();
                } else {
                    alert('Error deleting account');
                }
            });
    }
}

function clearForm() {
    document.getElementById('accountId').value = '';
    document.getElementById('username').value = '';
    document.getElementById('password').value = '';
}

document.addEventListener('DOMContentLoaded', fetchAccounts);