$(document).ready(function()
{
  $("#all").click(function(){
  console.log("ALL SHOULD SHOW");
    $(".NEWBORN").show();
    $(".BABY").show();
    $(".KIDS").show();
});

  $("#newborn").click(function(){
    $(".NEWBORN").show();
    $(".BABY").hide();
    $(".KIDS").hide();
  });

  $("#baby").click(function(){
  $(".NEWBORN").hide();
    $(".BABY").show();
    $(".KIDS").hide();

  });

  $("#kids").click(function(){
    $(".NEWBORN").hide();
    $(".BABY").hide();
    $(".KIDS").show();

  });
 });
