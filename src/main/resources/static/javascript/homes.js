const cookieArr = document.cookie.split("=")
const userId = cookieArr[1]

const categoryGeneratorInput = document.getElementById("categoryGeneratorInput")
const categoryGeneratorButton = document.getElementById("categoryGeneratorButton")

const recipeGeneratorInput = document.getElementById("recipeGeneratorInput")
const recipeGeneratorDropdown = document.getElementById("recipeGeneratorDropbox")
const recipeGeneratorButton = document.getElementById("recipeGeneratorButton")

const mealIdeaGeneratorButton = document.getElementById("mealIdeaGeneratorButton")

const categoryContainer = document.getElementById("categoryContainer")
const recipeContainer = document.getElementById("recipeContainer")
const ideasContainer = document.getElementById("ideasContainer")

const headers = {
  'Content-Type': 'application/json'
}

const categoryBaseUrl = "http://localhost:8080/api/v1/categories/"
const recipeBaseUrl = "http://localhost:8080/api/v1/recipes/"

const categorySubmitHandler = async (e) => {
  e.preventDefault()
  let bodyObj = {
    categoryName: categoryGeneratorInput.value
  }
  await addCategory(bodyObj);
  categoryGeneratorInput.value = ''
}

const recipeSubmitHandler = async (e) => {
  e.preventDefault()
  recipeGeneratorDropdown = document.getElementById("recipeGeneratorDropbox")
  let bodyObj = {
    recipeName: recipeGeneratorInput.value,
    recipeCategory: recipeGeneratorDropdown.value + " "
  }
  await addRecipe(bodyObj);
  recipeGeneratorInput.value = ''
  recipeGeneratorDropdown.value = ''
}

const mealIdeaSubmitHandler = async (e) => {
  e.preventDefault()
  let bodyObj = {
    body: randNum
  }
  await getMealIdeasById();
}

async function addCategory(obj) {
  const response = await fetch(`${categoryBaseUrl}user/${userId}`, {
    method: "POST",
    body: JSON.stringify(obj),
    headers: headers
  })
  .catch(err => console.error(err.message))
  if (response.status == 200) {
    return getCategories(userId);
  }
}

async function addRecipe(obj) {
  const response = await fetch(`${recipeBaseUrl}category/${obj.recipeCategory}`, {
    method: "POST",
    body: JSON.stringify(obj),
    headers: headers
  })
  .catch(err => console.error(err.message))
  if (response.status == 200) {
    return getRecipes();
  }
}

async function getCategories(userId) {
  await fetch(`${categoryBaseUrl}user/${userId}`, {
    method: "GET",
    headers: headers
  })
  .then(response => response.json())
  .then(data => createCategoryCard(data))
  .catch(err => console.error(err))
}

async function getRecipes() {
  await fetch(`${recipeBaseUrl}`, {
    method: "GET",
    headers: headers
  })
  .then(response => response.json())
  .then(data => createRecipeCard(data))
  .catch(err => console.error(err))
}

async function getMealIdeasById() {
  await fetch(`${recipeBaseUrl}random`, {
    method: "GET",
    headers: headers
  })
  .then(response => response.json())
  .then(data => createMealIdeaCard(data))
  .catch(err => console.error(err))
}

async function deleteCategory(categoryId){
  await fetch(categoryBaseUrl + categoryId, {
    method: "DELETE",
    headers: headers
  })
  .catch(err => console.error(err))

  return getCategories(userId);
}

async function deleteRecipe(recipeId){
  await fetch(recipeBaseUrl + recipeId, {
    method: "DELETE",
    headers: headers
  })
  .catch(err => console.error(err))

  return getRecipes(userId);
}

const createCategoryCard = (array) => {
  categoryContainer.innerHTML = ''
  array.forEach(obj => {
    let categoryCard = document.createElement("div")
      categoryCard.classList.add("card")
      categoryCard.innerHTML = `
        <p>${categoriesArr[i]}</p>
      `
    	categoryContainer.append(categoryCard)
  })
}

const createRecipeCard = (array) => {
  recipeContainer.innerHTML = ''
  array.forEach(obj => {
    let recipeCard = document.createElement("div")
    	recipeCard.classList.add("card")
    	recipeCard.innerHTML = `
    		<p>${recipesArr[i]}</p>
    	`
    	recipeContainer.append(recipeCard)
  })
}

const createMealIdeaCard = (array) => {
  ideaContainer.innerHTML = ''
  array.forEach(obj => {
    let ideaCard = document.createElement("div")
    		ideaCard.classList.add("card")
    		ideaCard.innerHTML = `
    			<p>${ideasArr[i]}
    		`
    		ideasContainer.append(ideaCard)
  })
}

function logoutHandler(){
  let c = document.cookie.split(";");
  for (let i in c) {
    document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
  }
}

categoryGeneratorButton.addEventListener("click", categorySubmitHandler)
recipeGeneratorButton.addEventListener("click", recipeSubmitHandler)
mealIdeaGeneratorButton.addEventListener("click", mealIdeaSubmitHandler)