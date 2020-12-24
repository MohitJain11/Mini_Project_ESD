let delete_organisation = document.getElementById("delete_organisation");
let update_organisation = document.getElementById("update_organisation");
window.onload = fetch_organisation_by_id;

delete_organisation.addEventListener("click", async (e) => {
    console.log("Hi, alumni details view");
    e.preventDefault();
    e.stopPropagation();
    let alumniOrganisationId = sessionStorage.getItem("alumniOrganisationId");
    console.log(alumniOrganisationId);
    if (delete_organisation.checkValidity() === true) {
        let response = await fetch('api/alumni/deleteOrganisation', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                alumniOrganisationId: sessionStorage.getItem("alumniOrganisationId"),
                organisationName: document.getElementById('organisationName').value,
                position: document.getElementById('position').value,
                joiningDate: document.getElementById('joiningDate').value,
                leavingDate: document.getElementById('leavingDate').value,
            })
        });
        let result = await response;
        console.log(result);
    }
    delete_organisation.classList.add('was-validated');
    location.href = "alumniorganizationedit.html";
});

update_organisation.addEventListener("click", async (e) => {
    console.log("Hi, alumni details view");
    e.preventDefault();
    e.stopPropagation();
    let alumniOrganisationId = sessionStorage.getItem("alumniOrganisationId");
    console.log(alumniOrganisationId);
    if (update_organisation.checkValidity() === true) {
        let response = await fetch('api/alumni/updateOrganisation', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                alumniOrganisationId: sessionStorage.getItem("alumniOrganisationId"),
                organisationName: document.getElementById('organisationName').value,
                position: document.getElementById('position').value,
                joiningDate: document.getElementById('joiningDate').value,
                leavingDate: document.getElementById('leavingDate').value,
            })
        });
        let result = await response;
        console.log(result);
    }
    update_organisation.classList.add('was-validated');
    location.href = "alumniorganizationedit.html";
});

async function fetch_organisation_by_id(){
    console.log(sessionStorage.getItem("alumniOrganisationId"));
    let response = await fetch("api/alumni/getOrganisationById", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            t: sessionStorage.getItem("alumniOrganisationId"),
        })
    });
    console.log("hi:");
    let organisationDetails = await response.json();
    console.log(organisationDetails);
    document.getElementById("organisationName").value = organisationDetails[0];
    document.getElementById("position").value = organisationDetails[1];
    document.getElementById("joiningDate").value = organisationDetails[2];
    document.getElementById("leavingDate").value = organisationDetails[3];
}