window.onload = fetch_organisation;

async function fetch_organisation(){
    let response = await fetch("api/alumni/getOrganisation");
    console.log("hi:");
    let alumniOrganisation = await response.json(); // read response body and parse as JSON
    console.log(alumniOrganisation);
    document.getElementById("first_name").value = alumniOrganisation[1];
    document.getElementById("last_name").value = alumniOrganisation[2];
    let alumni_organisation = document.getElementById('alumni_organisation');
    for(let i=0;i<(alumniOrganisation.length - 3)/5;i++){
        alumni_organisation.innerHTML += '<div class="row">\n' +
            '                <div class="col-md-6 mb-3">\n' +
            '                    <label for="organisationName">Organisation Name</label>\n' +
            '                    <input class="form-control" id="organisationName" disabled placeholder="" required type="text" value="'+alumniOrganisation[(i*5)+3]+'">\n' +
            '                    <div class="invalid-feedback">\n' +
            '                        Please enter a valid Organisation Name.\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '                <div class="col-md-6 mb-3">\n' +
            '                    <label for="position">position</label>\n' +
            '                    <input class="form-control" id="position" disabled placeholder="" required type="text" value="'+alumniOrganisation[(i*5)+4]+'">\n' +
            '                    <div class="invalid-feedback">\n' +
            '                        Please enter valid Position.\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="row">\n' +
            '                <div class="col-md-6 mb-3">\n' +
            '                    <label for="joiningDate">Joining Date</label>\n' +
            '                    <input class="form-control" id="joiningDate" disabled placeholder="" required type="text" value="'+alumniOrganisation[(i*5)+5]+'">\n' +
            '                    <div class="invalid-feedback">\n' +
            '                        Please enter a Joining Date.\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '                <div class="col-md-6 mb-3">\n' +
            '                    <label for="leavingDate">Leaving Date</label>\n' +
            '                    <input class="form-control" id="leavingDate" disabled placeholder="" required type="text" value="'+alumniOrganisation[(i*5)+6]+'">\n' +
            '                    <div class="invalid-feedback">\n' +
            '                        Please enter valid Leaving Date.\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <hr class="mb-4">\n' +
            '            <div class="row">\n' +
            '                <div class="col-md-6 mb-3">\n' +
            '                    <button class="btn btn-primary btn-lg btn-block" id="'+alumniOrganisation[(i*5)+7]+'" type="button">Edit / Delete</button>\n' +
            '                </div>\n' +
            '            </div>' +
            '            <br />'
    }

    let li = document.getElementsByTagName("button");
    for(let i = 0;i<i<(alumniOrganisation.length - 3)/5;i++){
        li[i].addEventListener("click", myScript);
    }

    function myScript(e){
        // alert(e.target.attributes.id.value);
        sessionStorage.setItem("alumniOrganisationId", e.target.attributes.id.value);
        location.href = "organisationeditdelete.html";
    }
}