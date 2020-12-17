$(document).ready(function()
{
  $("#all").click(function(){
  //console.log("ALL SHOULD SHOW");
    $(".NEWBORN").show();
    $(".BABY").show();
    $(".KIDS").show();
    $("#newborn").removeClass("active");
    $("#baby").removeClass("active");
    $("#kids").removeClass("active");
    $("#all").addClass("active");
  });

  $("#newborn").click(function(){
    $(".NEWBORN").show();
    $(".BABY").hide();
    $(".KIDS").hide();
    $("#newborn").addClass("active");
    $("#baby").removeClass("active");
    $("#kids").removeClass("active");
    $("#all").removeClass("active");
  });

  $("#baby").click(function(){
  $(".NEWBORN").hide();
    $(".BABY").show();
    $(".KIDS").hide();
    $("#newborn").removeClass("active");
    $("#baby").addClass("active");
    $("#kids").removeClass("active");
    $("#all").removeClass("active");
  });

  $("#kids").click(function(){
    $(".NEWBORN").hide();
    $(".BABY").hide();
    $(".KIDS").show();
    $("#newborn").removeClass("active");
    $("#baby").removeClass("active");
    $("#kids").addClass("active");
    $("#all").removeClass("active");
  });
 });
