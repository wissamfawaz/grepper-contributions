
// The below code creates 3 paragraphs
// and adds them to document body

// 1. Create in-memory fragment to enhance performance
const fragment = document.createDocumentFragment();
const paragraphs = ["Paragraph1", "Paragraph2", "Paragraph3"];
// 2. Add paragraphs one by one to fragment
paragraphs.forEach((paragraph) => {
  const p = document.createElement("p");
  p.textContent = paragraph;
  fragment.appendChild(p);
});
// 3. Add resulting fragment to main DOM tree
document.body.appendChild(fragment);
