let add_new_organisation = document.getElementById('add-organisation');


add_new_organisation.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (add_new_organisation.checkValidity() === true) {
        console.log("position:", document.getElementById('position').value);
        let response = await fetch('api/alumni/register_organisation', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                organisationName: document.getElementById('organisation_name').value,
                position: document.getElementById('position').value,
                joiningDate: document.getElementById('joining_date').value,
                leavingDate: document.getElementById('leaving_date').value
            })
        });
        let result = await response;
        console.log(result);
        if(result['status'] === 200){
            let data = response.json();
            location.href = "alumnieducationedit.html";
        }
    }
    add_new_organisation.classList.add('was-validated');
});