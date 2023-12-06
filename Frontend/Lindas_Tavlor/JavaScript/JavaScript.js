	let navbar = document.getElementById("navigation");
	let sticky = navbar.offsetTop;

window.onscroll = function() {stickyNav()};	
	
function stickyNav() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}
window.onload = function(){randomImg()};
function randomImg(){
	
	let myImages = new Array();
	
	
	myImages[0] = "../Images/IMG_7743.jpg";
	myImages[1] = "../Images/IMG_4696.jpg";
	myImages[2] = "../Images/IMG_7725 3.jpg";
	myImages[3] = "../Images/IMG_7727.jpg";
	myImages[4] = "../Images/IMG_7728.jpg";
	myImages[5] = "../Images/IMG_7729.jpg";
	myImages[6] = "../Images/IMG_7732.jpg";
	myImages[7] = "../Images/IMG_7734.jpg";
	
	
	let rnd = Math.floor(Math.random() * Math.floor(myImages.length) ) ;

	
	document.getElementById("randomImage").setAttribute("src",myImages[rnd]);

}