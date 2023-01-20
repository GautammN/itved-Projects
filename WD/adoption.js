const form = document.querySelector("form");
const thankYouMessage = document.querySelector("#registerSuccessModal");
form.addEventListener("submit", (e) => {
  e.preventDefault();
  thankYouMessage.classList.add("show");
  setTimeout(() => form.submit(), 3000);
});