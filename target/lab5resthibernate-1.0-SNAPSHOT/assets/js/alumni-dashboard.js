let alumni_details_view = document.getElementById('view_details_button');
let alumni_details_edit = document.getElementById('edit_details_button');

let alumni_education_view = document.getElementById('view_education_button');
let alumni_education_edit = document.getElementById('edit_education_button');

let alumni_organisation_view = document.getElementById('view_organisation_button');
let alumni_organisation_edit = document.getElementById('edit_organisation_button');

alumni_details_view.addEventListener('click', async (e) => {
    console.log("Hi, alumni details view");
    location.href = "index.html";
});

alumni_details_edit.addEventListener('click', async (e) => {
    console.log("Hi, alumni edit");
    location.href = "alumnidetailsedit.html";
});

alumni_education_edit.addEventListener('click', async (e) => {
    console.log("Hi, alumni_education_view");
    location.href = "alumnieducationedit.html";
});

alumni_organisation_edit.addEventListener('click', async (e) => {
    console.log("Hi, alumni_organisation_edit");
    location.href = "alumniorganizationedit.html";
});


