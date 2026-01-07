# Minimal Experience Platform 
Design and implement a modern frontend experience backed by a headless CMS and a microservice-based backend

# 1. Frontend (SPA)
  Build a Single Page Application (SPA) using React JS:
   1. Fetch and display product data from the backend REST API
   2. Fetch and render content (e.g. page title, banner, description) from the headless CMS
   3. Basic routing (e.g. Home / Products)

## Implementation Summary
- Install Node.js & npm
- Create project with Vite
- Add folders for API, components, pages
- Install dependencies (router, axios, toastify, skeleton)
- Connect to backend & CMS
- Run locally with npm run dev
- Build with npm run build
- Deploy to the npx server

## Design Considerations
* Separation of concerns: API calls isolated in /api.
* Reusable components: Banner, ProductCard, Layout.
* Routing: Centralized in routes.js.
* Maintainability: Clear folder structure, easy to extend.
* Error handling: Add try/catch in API calls for resilience.
* Styling: Use CSS modules or styled-components for scoped styles.
* Error Boundary ensures the app doesn’t crash entirely if a component fails.
* Skeletons provide immediate feedback, reducing perceived wait time.
* Fallback messages (like “Error loading content”) keep users informed.
* Toast notifications appear globally in the top-right corner when API errors occur.

## Project Structure 

<img width="341" height="562" alt="image" src="https://github.com/user-attachments/assets/35ae107d-62d0-460d-bd94-4873a9845330" />

## Dependencies 
npm install react-router-dom axios react-toastify react-loading-skeleton

## Run Locally
npm run dev

Open browser at the URL shown - http://localhost:5173.

## Build for Production
npm run build

This generates a dist/folder with optimized static files.

To preview:
npm run preview

# 2. Backend (SPA)

Minimalist Spring Boot microservice that serves an in-memory list of products via GET /products, includes OpenAPI/Swagger, error handling, and basic tests.

## Project structure

<img width="341" height="562" alt="image" src="https://github.com/user-attachments/assets/ab97ce29-7952-4e18-b819-a2ce11905269" />

## How to run

* Build: mvn clean package
* Run: mvn spring-boot:run
* API: GET http://localhost:8080/products
* Swagger UI: http://localhost:8080/swagger-ui.html
* OpenAPI JSON: http://localhost:8080/v3/api-docs




