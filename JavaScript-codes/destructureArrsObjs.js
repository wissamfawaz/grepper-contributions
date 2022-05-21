// Array to destructure
const arr = ["Wissam", "Fawzi", "Darwich", "Fawaz"];
// First element, second element, and then remaining ones
const [firstName, middleName, ...restOfName] = arr;
console.log(firstName); // Wissam
console.log(middleName); // Fawzi
console.log(restOfName.join(" ")); // Darwich Fawaz

// Object to destructure
const socialMedia = {
  twitter: "@wissam_f",
  facebook: "https://www.facebook.com/wissam.fawaz",
  linkedin: "https://www.linkedin.com/in/wissam-fawaz-6b440839/",
};
// To extract values, property keys should be used
const { twitter, linkedin } = socialMedia;
// Twitter: @wissam_f
console.log("Twitter:", twitter);
// LinkedIn: https://www.linkedin.com/in/wissam-fawaz-6b440839/
console.log("LinkedIn:", linkedin);
