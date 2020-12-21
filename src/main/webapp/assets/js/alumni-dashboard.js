let alumni_details_view = document.getElementById('view_details_button');
let alumni_details_edit = document.getElementById('edit_details_button');

alumni_details_view.addEventListener('click', async (e) => {
    console.log("Hi, alumni details view");
    location.href = "index.html";
});

alumni_details_edit.addEventListener('click', async (e) => {
    console.log("Hi, alumni edit");
    location.href = "alumnidetailsedit.html";
});


