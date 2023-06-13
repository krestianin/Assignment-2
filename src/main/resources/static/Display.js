//   // Function to generate the diagram
//   function generateHistogram() {
//     var histogram = document.getElementById("histogram");
  
//     histogram.style.display="flex";
//     histogram.style.flexDirection = "row ";
//     //histogram.style.justifyContent = "center";
//     histogram.innerHTML = '';
  
//     students.forEach(function(student) {
//       var studentDiv = document.createElement('div');
//       studentDiv.classList.add('studentBar');
//       studentDiv.style.paddingRight = "2em";
//       studentDiv.innerHTML = '';

      
//       var nameDiv = document.createElement('div');
//       nameDiv.classList.add('name');
//       nameDiv.textContent = student.name;
  
//       var heightBar = document.createElement('div');
//       heightBar.classList.add('height-bar');
//       heightBar.style.height = student.height + 'px';
//       heightBar.style.width = student.weight + 'px';
//       heightBar.style.backgroundColor = '#3498db';
//       heightBar.innerHTML = student.GPA;

//     //  var weightBar = document.createElement('div');
//     //   weightBar.classList.add('weight-bar');
//     //   weightBar.style.height = student.weight + 'px';
//     //   weightBar.style.backgroundColor = 'red';
  
//       studentDiv.appendChild(nameDiv);
//       studentDiv.appendChild(heightBar);
//     // studentDiv.appendChild(weightBar);
  
//       histogram.appendChild(studentDiv);


    
//         console.log(students);
//     });
//   }
  
//   generateHistogram();
// // var students = [
// //     { name: "Steve", age: 20, grade: "A" },
// //     { name: "John", age: 19, grade: "B" },
// //     { name: "Sarah", age: 21, grade: "A+" },
// //     // Add more student objects as needed
// //   ];
  
// //   var histogram = document.getElementById("histogram");
  
// //   histogram.style.display="flex";

// //   histogram.style.flexDirection = "row ";
// //   histogram.style.justifyContent = "center";

// //   students.forEach(function(student) {
// //     var studentElement = document.createElement("div");
// //     studentElement.className = "student-bar";
// //     studentElement.textContent = student.name;
// //     studentElement.style.width = student.age * 10 + "px"; // Adjust the width as per your preference
// //     studentElement.style.backgroundColor = 'red';
// //     // studentElement.style.display="flex";// flex-direction: row; justify-content: center; align-items: left;"
// //     // studentElement.style.flexDirection = "row ";
    
// //     // Add click event listener to redirect to student's updated page
// //     studentElement.addEventListener("click", function() {
// //       window.location.href = "student_page.html?name=" + student.name; // Update the URL with the student's name or ID
// //     });
  
// //     histogram.appendChild(studentElement);
// //   });




$(document).ready(function() {
  $(".box").each(function() {
    var nameDiv = document.createElement('div');
    nameDiv.classList.add('name');
    var name = $(this).data("name");
    var width = $(this).data("width");
    var height = $(this).data("height");
    
    $(this).css("width", width*2.5 + "px");
    $(this).css("textContent", name );
    $(this).css("height", height*1.5 + "px");

    $(this).click(function() {
      var studentId = $(this).data("student-id");
      var studentName = $(this).data("name");
      var studentLastName = $(this).data("last-name");
      var studentHeight = $(this).data("height");
      var studentWeight = $(this).data("width");
      var studentHairColor = $(this).data("hair-color");
      var studentGPA = $(this).data("gpa");
      console.log(studentGPA);
      $("#id").val(studentId);
      $("#editName").val(studentName);
      $("#editLastName").val(studentLastName);
      $("#editHeight").val(studentHeight);
      $("#editWeight").val(studentWeight);
      $("#editHairColor").val(studentHairColor);
      $("#editGPA").val(studentGPA);
  
      $("#editModal").modal("show");
      });
  

    });
    
  $("#deleteButton").click(function() {
      $("#editForm").attr("action", "/students/deleteHisto").submit();
  });
    
    
});
