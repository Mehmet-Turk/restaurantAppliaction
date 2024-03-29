(function ($) {
    "use strict";

    // Spinner
    var spinner = function () {
        setTimeout(function () {
            if ($('#spinner').length > 0) {
                $('#spinner').removeClass('show');
            }
        }, 1);
    };
    spinner();
    
    
//     Initiate the wowjs
    new WOW().init();

  });
    // Sticky Navbar
  $(window).scroll(function () {
    if ($(this).scrollTop() > 45) {
      $('.navbar').addClass('sticky-top shadow-sm').css('width', '100%');
    } else {
      $('.navbar').removeClass('sticky-top shadow-sm').css('width', 'auto');
    }
  });

    
    
    // Dropdown on mouse hover
    const $dropdown = $(".dropdown");
    const $dropdownToggle = $(".dropdown-toggle");
    const $dropdownMenu = $(".dropdown-menu");
    const showClass = "show";
    
    $(window).on("load resize", function() {
        if (this.matchMedia("(min-width: 992px)").matches) {
            $dropdown.hover(
            function() {
                const $this = $(this);
                $this.addClass(showClass);
                $this.find($dropdownToggle).attr("aria-expanded", "true");
                $this.find($dropdownMenu).addClass(showClass);
            },
            function() {
                const $this = $(this);
                $this.removeClass(showClass);
                $this.find($dropdownToggle).attr("aria-expanded", "false");
                $this.find($dropdownMenu).removeClass(showClass);
            }
            );
        } else {
            $dropdown.off("mouseenter mouseleave");
        }
    });
    
    
    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 200, 'easeInOutExpo');
        return false;
    });


    // Facts counter
    $('[data-toggle="counter-up"]').counterUp({
        delay: 10,
        time: 2000
    });


    // Modal Video
    $(document).ready(function () {
        var $videoSrc;
        $('.btn-play').click(function () {
            $videoSrc = $(this).data("src");
        });
        console.log($videoSrc);console.log(1);

        $('#videoModal').on('shown.bs.modal', function (e) {
            $("#video").attr('src', $videoSrc + "?autoplay=1&amp;modestbranding=1&amp;showinfo=0");
        })

        $('#videoModal').on('hide.bs.modal', function (e) {
            $("#video").attr('src', $videoSrc);
        })
    });


    // Testimonials carousel
    $(".testimonial-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 1000,
        center: true,
        margin: 24,
        dots: true,
        loop: true,
        nav : false,
        responsive: {
            0:{
                items:1
            },
            768:{
                items:2
            },
            992:{
                items:3
            }
        }
    });
    

(jQuery);




// Date
//$(function() {
//  var currentDate = new Date();
//  var firstDayOfMonth = new Date(currentDate.getFullYear(), currentDate.getMonth(), 1);
//  $('#myDateInput').datetimepicker({
//    timepicker: false,
//    format: 'd-m-Y',
//    minDate: new Date(currentYear, currentMonth, today),
//    defaultDate: firstDayOfMonth,
//    required: true
//  });
//});
$(function() {
  var currentDate = new Date();
  var today = currentDate.getDate();
  var currentMonth = currentDate.getMonth();
  var currentYear = currentDate.getFullYear();

  $('#myDateInput').datetimepicker({
    timepicker: false,
    format: 'd-m-Y',
    minDate: new Date(currentYear, currentMonth, today), // Bugün ve sonrasını seçilebilir yap
    required: true
  });
});


    // Time 
      const timeSelectionDiv = document.getElementById("timeSelection");

        for (let hour = 7; hour <= 21; hour++) {
            for (let minute = 0; minute < 60; minute += 30) {
                const timeBox = document.createElement("div");
                timeBox.classList.add("timeBox");
                timeBox.textContent = ("0" + hour).slice(-2) + ":" + ("0" + minute).slice(-2);
                    if(hour == 21  && minute >= 30){
                    break;}
                timeBox.addEventListener("click", function () {
                    if (timeBox.classList.contains("selected")) {
                        timeBox.classList.remove("selected");
                    } else {
                        const selectedBox = document.querySelector(".timeBox.selected");
                        if (selectedBox) {
                            selectedBox.classList.remove("selected");
                        }
                        timeBox.classList.add("selected");
                        const selectedTime = timeBox.textContent;
                        console.log("Selected Time:", selectedTime);
                    }
                });
 if(timeSelectionDiv){
      timeSelectionDiv.appendChild(timeBox);
                }
//                 timeSelectionDiv.appendChild(timeBox);
            }
        }
        // Phone 
         var input = document.querySelector("#phone");
        var iti = window.intlTelInput(input, {
            initialCountry: "auto",
            separateDialCode: true,
            nationalMode: false,
            preferredCountries: ["us", "ca"],
            utilsScript: "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.min.js"
        });
        input.addEventListener("input", function () {
            input.value = input.value.replace(/[^0-9]/g, "").slice(0, 12);
        });


//roomNumberContainer
document.getElementById('select').addEventListener('change', function() {
  var roomNumberContainer = document.getElementById('roomNumberContainer');
  var selectValue = this.value;

  if (selectValue === 'Yes') {
    roomNumberContainer.style.display = 'block';
  } else {
    roomNumberContainer.style.display = 'none';
  }
});

$(function ($) {
  "use strict";

  // ...

  // Login form
  $("form").submit(function (event) {
    event.preventDefault(); // Prevent form submission

    // Get the entered email and password values
    var email = $("#username").val();
    var password = $("#password").val();

    // Perform your validation logic here
    var isValid = validateLogin(email, password);

    // Show error message if validation fails
    if (!isValid) {
      $(".error").text("Wrong email or password").show();
      return;
    }

    // Proceed with form submission if validation passes
    this.submit();
  });

  // ...

})(jQuery);

// Function to validate login credentials
function validateLogin(email, password) {
  // Implement your validation logic here
  // Return true if the credentials are valid, false otherwise
  // For example:
  if (email === "example@example.com" && password === "password") {
    return true;
  } else {
    return false;
  }
};




