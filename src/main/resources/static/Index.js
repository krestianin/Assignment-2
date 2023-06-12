$(document).ready(function() {

    $(".editButton").click(function() {
      var studentId = $(this).data("student-id");
      var studentName = $(this).closest("tr").find("td:eq(0)").text();
      var studentLastName = $(this).closest("tr").find("td:eq(1)").text();
      var studentHeight = $(this).closest("tr").find("td:eq(2)").text();
      var studentWeight = $(this).closest("tr").find("td:eq(3)").text();
      var studentHairColor = $(this).closest("tr").find("td:eq(4)").text();
      var studentGPA = $(this).closest("tr").find("td:eq(5)").text();

      $("#id").val(studentId);
      $("#editName").val(studentName);
      $("#editLastName").val(studentLastName);
      $("#editHeight").val(studentHeight);
      $("#editWeight").val(studentWeight);
      $("#editHairColor").val(studentHairColor);
      $("#editGPA").val(studentGPA);

      $("#editModal").modal("show");
    });

    
    $(".deleteButton").click(function() {
  // Get the student id from the data attribute of the parent row
  var studentId = $(this).closest("tr").find(".editButton").data("student-id");
   console.log(studentId)
  // Set the student id in the hidden input field of the form
      $("#id").val(studentId);
      $("#editForm").attr("action", "/students/delete").submit();
  });
  });