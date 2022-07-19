 let athenticationUserInfo = $('#tableAthenticationUser')

 showUserInfo()

function showUserInfo() {
    fetch("/api/authenticatedUsers").then((response) => {
        console.log(response.statusText + response.status)
        if (response.ok) {
            response.json().then((user) => {
                console.log(user)
               addUserForTable(user)
            });
        } else {
            console.error(response.statusText + response.status)
        }
    })
}

function addUserForTable(user) {
    athenticationUserInfo.append(
        '<tr>' +
        '<td>' + user.id + '</td>' +
        '<td>' + user.firstname + '</td>' +
        '<td>' + user.lastname + '</td>' +
        '<td>' + user.email + '</td>' +
        '<td>' + user.age + '</td>' +
        '<td>' + user.roles.map(roleUser => roleUser.name) + '</td>' +
        '</tr>'
    )
}

