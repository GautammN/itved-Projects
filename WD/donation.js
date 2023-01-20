function makeUppercase(txt)
{
	txt.value = txt.value.toUpperCase();
}

const form = document.querySelector("form");
const thankYouMessage = document.querySelector("#paymentSuccessModal");
form.addEventListener("submit", (e) => {
  e.preventDefault();
  thankYouMessage.classList.add("show");
  setTimeout(() => form.submit(), 3000);
});



