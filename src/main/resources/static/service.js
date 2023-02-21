class Person {
    constructor(id_, fname_, lname_) {
        this.id = id_;
        this.firstName = fname_;
        this.lastName = lname_;
    }
}

function create(e) {
    e.preventDefault();
    console.log("click")
    const firstName = document.getElementById("fname").value;
    const lastName = document.getElementById("lname").value;
    const jsonPerson = new Person(0, firstName, lastName);
    const personData = JSON.stringify(jsonPerson);
    console.log(personData)

    $.ajax({
        type: "POST",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/person-controller/create",
        data: personData,
        dataType: "JSON ",
        success: function (response) {
            alert(JSON.stringify(response));
        },
        error: function () {
            alert('Error while request..');
        }
    });

}

function read(e) {
    e.preventDefault();
    const id = document.getElementById("person-id").value;

    $.ajax({
        type: "GET",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/person-controller/read/".concat(id),
         dataType: "JSON",
        success: function (response) {
            alert(JSON.stringify(response));
        },
        error: function () {
            alert('Error while request..');
        }
    });
}


function readAll(e) {
    e.preventDefault();

    $.ajax({
        type: "GET",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/person-controller/read-all",
         dataType: "JSON",
        success: function (response) {
            alert(JSON.stringify(response));
        },
        error: function () {
            alert('Error while request..');
        }
    });
}


function update(e) {
    e.preventDefault();
    const id = document.getElementById("person-id").value;
    const firstName = document.getElementById("fname").value;
    const lastName = document.getElementById("lname").value;
    const jsonPerson = new Person(0, firstName, lastName);
    const personData = JSON.stringify(jsonPerson);

    $.ajax({
        type: "PUT",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/person-controller/update/".concat(id),
        data: personData,
        dataType: "JSON",
        success: function (response) {
            alert(JSON.stringify(response));
        },
        error: function () {
            alert('Error while request..');
        }
    });
}


function destroy(e) {
    e.preventDefault();
    const id = document.getElementById("person-id").value;

    $.ajax({
        type: "DELETE",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/person-controller/delete/".concat(id),
        dataType: "JSON",
        success: function (response) {
            alert(JSON.stringify(response));
        },
        error: function () {
            alert('Error while request..');
        }
    });
}