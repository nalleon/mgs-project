document.getElementById('getOne').addEventListener('click', function() {
    var weaponId = document.getElementById('id').value;
    fetch('http://localhost:8080/api-mgs/v1/weapon/' + id)
        .then(response => response.json())
        .then(data => {
            var result = document.getElementById('result');
            result.innerHTML = '';
            if (data.error) {
                result.innerHTML = '<p>Error: ' + data.error + '</p>';
            } else {
                result.innerHTML = '<p>ID: ' + data.id + '</p>' +
                                      '<p>Name: ' + data.name + '</p>' +
                                      '<p>Type: ' + data.type + '</p>';
            }
        })
        .catch(error => {
            console.error('Error:', error);
            var result = document.getElementById('result');
            result.innerHTML = '<p>Error while processing solicitude.</p>';
        });
});

// obtainAll   
document.getElementById('getAll').addEventListener('click', function() {
    fetch('http://localhost:8080/api-mgs/v1/weapon')
        .then(response => response.json())
        .then(data => {
            var resultAll = document.getElementById('resultAll');
            resultAll.innerHTML = '';
            if (data.error) {
                resultAll.innerHTML = '<p>Error: ' + data.error + '</p>';
            } else {
                showObjects(data, resultAll);
                if (data.length > 10) {
                    var showMoreBtn = document.getElementById('showMore');
                    showMoreBtn.style.display = 'block';
                    var counter = 10;
                    showMoreBtn.addEventListener('click', function() {
                        var nextObject = data.slice(counter, counter + 10);
                        showObjects(nextObject, resultAll, true);
                        counter += 10;
                        if (counter >= data.length) {
                            showMoreBtn.style.display = 'none';
                        }
                    });
                }
            }
        })
        .catch(error => {
            console.error('Error:', error);
            var resultAll = document.getElementById('resultAll');
            resultAll.innerHTML = '<p>Error while processing solicitude.</p>';
        });
});

var counter = 0;

function showObjects(weapons, container, append = false) {
    if (!append) {
        container.innerHTML = '';
        counter = 0; 
    }

    var showQuantity = Math.min(10, weapons.length - counter);

    for (var i = 0; i < showQuantity; i++) {
        var weapon = weapons[counter + i];
        var weaponHTML = '<div>' +
                            '<p>ID: ' + weapon.id + '</p>' +
                            '<p>Name: ' + weapon.name + '</p>' +
                            '<p>Type: ' + weapon.type + '</p>' +                
                            '</div>';
        container.innerHTML += weaponHTML; 
    }

    counter += showQuantity; 
}

document.getElementById('save').addEventListener('click', function(event) {
    event.preventDefault();

    var objectName = document.getElementById('name').value;
    var objectType = document.getElementById('type').value;
    var objectId = document.getElementById('id').value;

    var weaponDTO = {
        id: objectId,
        name: objectName,
        type: objectType
    };

    save(weaponDTO);

});

function save(weaponDTO) {
    var weapon = {
        id: weaponDTO.id,
        name: weaponDTO.name,
        type: weaponDTO.type
    };

    fetch('http://localhost:8080/api-mgs/v1/weapon/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(weapon)
    })
    .then(response => {
        if (response.ok) {
            console.log('weapon guardado exitosamente.');
            // Realizar alguna acción adicional si es necesario
        } else {
            console.error('Error al guardar el weapon:', response.statusText);
            // Manejar el error de alguna manera si es necesario
        }
    })
    .catch(error => {
        console.error('Error al realizar la solicitud:', error);
        // Manejar el error de alguna manera si es necesario
    });
}

document.getElementById('delete').addEventListener('click', function(event) {
    event.preventDefault(); // Evita que el formulario se envíe automáticamente

    // Obtener el ID del weapon a borrar
    var objectIdToDelete = document.getElementById('objectIdToDelete').value;

    // Llama a la función para borrar el weapon, pasando el ID del weapon
    borrarweapon(objectIdToDelete);
});

function borrarweapon(objectId) {
    fetch('http://localhost:8080/api-mgs/v1/weapon/delete/' + objectId, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            var deleteMessage = document.getElementById('deleteMessage');
            deleteMessage.innerText = 'weapon eliminado exitosamente.';
            // Realizar alguna acción adicional si es necesario
            setTimeout(function() {
                if (deleteMessage.innerText === 'weapon eliminado exitosamente.') {
                    deleteMessage.innerText = ''; // Borra el mensaje después de 5 segundos si no ha sido modificado
                }
            }, 10000); // 5000 milisegundos = 5 segundos
        } else {
            document.getElementById('deleteMessage').innerText = 'Error al eliminar el weapon: ' + response.statusText;
            // Manejar el error de alguna manera si es necesario
        }
    })
    .catch(error => {
        document.getElementById('deleteMessage').innerText = 'Error al realizar la solicitud: ' + error;
        // Manejar el error de alguna manera si es necesario
    });
}