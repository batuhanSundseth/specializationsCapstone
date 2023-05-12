const categoryGeneratorInput = document.getElementById("categoryGeneratorInput")
const categoryGeneratorButton = document.getElementById("categoryGeneratorButton")

const recipeGeneratorInput = document.getElementById("recipeGeneratorInput")
const recipeGeneratorDropdown = document.getElementById("recipeGeneratorDropbox")
const recipeGeneratorButton = document.getElementById("recipeGeneratorButton")

const mealIdeaGeneratorButton = document.getElementById("mealIdeaGeneratorButton")

const categoryContainer = document.getElementById("categoryContainer")
const recipeContainer = document.getElementById("recipeContainer")
const ideasContainer = document.getElementById("ideasContainer")

let categoriesArr=["Chinese", "Mexican", "Italian", "American"]
let recipesArr=["Dumplings (Chinese)", "Pizza (Italian)", "Spaghetti (Italian)", "Tacos (Mexican)", "Burgers (American)", "Fried Rice (Chinese)"]
let ideasArr=[]

let categoriesIterator=0
let recipesIterator=0
let ideasIterator=0


function listCategoryCards() {
	categoryContainer.innerHTML = ` `
	for (let i = 0; i <= categoriesIterator; i++) {
    let categoryCard = document.createElement("div")
    categoryCard.classList.add("card")
    categoryCard.innerHTML = `
      <p>${categoriesArr[i]}</p>
    `
    categoryContainer.append(categoryCard)
	}
	categoriesIterator++
}

function listRecipeCards() {
	recipeContainer.innerHTML = ` `
	for (let i = 0; i <= recipesIterator; i++) {
		let recipeCard = document.createElement("div")
		recipeCard.classList.add("card")
		recipeCard.innerHTML = `
			<p>${recipesArr[i]}</p>
		`
		recipeContainer.append(recipeCard)
	}
	recipesIterator++
}

function listIdeaCards() {
	ideasArr.push(recipesArr[Math.floor(Math.random() * recipesArr.length)])
	ideasContainer.innerHTML = ` `
	for (let i = 0; i <= ideasIterator; i++) {
		let ideaCard = document.createElement("div")
		ideaCard.classList.add("card")
		ideaCard.innerHTML = `
			<p>${ideasArr[i]}
		`
		ideasContainer.append(ideaCard)
	}
	ideasIterator++
}

categoryGeneratorButton.addEventListener("click", listCategoryCards)
recipeGeneratorButton.addEventListener("click", listRecipeCards)
mealIdeaGeneratorButton.addEventListener("click", listIdeaCards)