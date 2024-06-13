document.getElementById('getAll').addEventListener('click', function() {
    fetch('http://localhost:8080/api-mgs/v1/weapon/findAll/')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(weapons => {
            const resultAll = document.getElementById('resultAll');
            resultAll.innerHTML = '';
            weapons.forEach(weapon => {
                const weaponDiv = document.createElement('div');
                weaponDiv.classList.add('Weapon');
                weaponDiv.innerHTML = `
                    <h2>${weapon.name}</h2>
                    <p>Type: ${weapon.type}</p>
                `;
                resultAll.appendChild(weaponDiv);
            });
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
            document.getElementById('resultAll').innerHTML = '<p>There was an error fetching the data.</p>';
        });
});