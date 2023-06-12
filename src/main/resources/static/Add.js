 src="Display.js"

    var form = document.getElementById("newStudentForm");

    form.addEventListener("submit", function(event) {
      event.preventDefault();

      // Get the input values
      var name = document.getElementById("name").value;
      var age = parseInt(document.getElementById("age").value);
      var height = parseInt(document.getElementById("height").value);
      var weight = parseInt(document.getElementById("weight").value);
      var hairColor = document.getElementById("hairColor").value;

      // Call the addStudent function from your other JavaScript code
      addStudent(name, age, height, weight, hairColor);

      // Optional: Display a success message or redirect to another page
      alert("New student added successfully!");
      });