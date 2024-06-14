document.addEventListener('DOMContentLoaded', () => {
  const apiUrl = 'http://localhost:8080/api/vendedores';

  const form = document.getElementById('vendedorForm');
  const vendedoresTable = document.getElementById('vendedoresTable').querySelector('tbody');

  // Função para carregar a lista de vendedores
  const loadVendedores = async () => {
    const response = await fetch(apiUrl);
    const vendedores = await response.json();
    vendedoresTable.innerHTML = '';
    vendedores.forEach(vendedor => {
      const row = document.createElement('tr');
      row.innerHTML = `
        <td>${vendedor.vendedorId}</td>
        <td>${vendedor.vendedorNome}</td>
        <td>${vendedor.vendedorEndereco}</td>
        <td>${vendedor.vendedorTelefone}</td>
        <td class="actions">
          <button onclick="editVendedor('${vendedor.vendedorId}')">Editar</button>
          <button onclick="deleteVendedor('${vendedor.vendedorId}')">Deletar</button>
        </td>
      `;
      vendedoresTable.appendChild(row);
    });
  };

  // Função para adicionar/atualizar vendedor
  form.addEventListener('submit', async (e) => {
    e.preventDefault();
    const formData = new FormData(form);
    const data = {};
    formData.forEach((value, key) => data[key] = value);

    const method = data.vendedorId ? 'PUT' : 'POST';
    const url = data.vendedorId ? `${apiUrl}/${data.vendedorId}` : apiUrl;

    try {
      const response = await fetch(url, {
        method,
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
      });

      if (response.ok) {
        form.reset();
        loadVendedores();
      } else {
        console.error('Erro ao salvar vendedor:', response.statusText);
      }
    } catch (error) {
      console.error('Erro ao salvar vendedor:', error);
    }
  });

  // Função para editar vendedor
  window.editVendedor = async (id) => {
    const response = await fetch(`${apiUrl}/${id}`);
    const vendedor = await response.json();
    form.vendedorId.value = vendedor.vendedorId;
    form.vendedorNome.value = vendedor.vendedorNome;
    form.vendedorEndereco.value = vendedor.vendedorEndereco;
    form.vendedorTelefone.value = vendedor.vendedorTelefone;
  };

  // Função para deletar vendedor
  window.deleteVendedor = async (id) => {
    try {
      const response = await fetch(`${apiUrl}/${id}`, {
        method: 'DELETE',
      });

      if (response.ok) {
        loadVendedores();
      } else {
        console.error('Erro ao deletar vendedor:', response.statusText);
      }
    } catch (error) {
      console.error('Erro ao deletar vendedor:', error);
    }
  };


  loadVendedores();
});
