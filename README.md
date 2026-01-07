# Experience Platform - Pilot version
Design and implement a modern frontend experience backed by a headless CMS and a microservice-based backend

# Application Architecture
<img width="985" height="414" alt="image" src="https://github.com/user-attachments/assets/8cfa5700-24dc-48d9-9f29-5c76f6dd5c30" />


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
* <b>Separation of concerns</b>: API calls isolated in /api.
* <b>Reusable components</b>: Banner, ProductCard, Layout.
* <b>Routing</b>: Centralized in routes.js.
* <b>Maintainability</b>: Clear folder structure, easy to extend.
* <b>Error handling</b>: Add try/catch in API calls for resilience.
* <b>Styling</b>: Use CSS modules or styled-components for scoped styles.
* <b>Error Boundary</b> ensures the app doesn’t crash entirely if a component fails.
* <b>Skeletons</b> provide immediate feedback, reducing perceived wait time.
* <b>Fallback</b> messages (like “Error loading content”) keep users informed.
* <b>Toast notifications</b> appear globally in the top-right corner when API errors occur.

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

# 3. Containerization
- Single command starts the full stack.
- Clear separation of services.
- Reasonable ports: 3000 (frontend), 8080 (backend), 1337 (CMS).

## Directory Layout 
<img width="669" height="165" alt="image" src="https://github.com/user-attachments/assets/cc17eef6-2cb5-4474-bfbd-97d4541af233" />

## How It Works
- Frontend: React app built and served via Nginx on port 3000.
- Backend: Spring Boot API exposed on port 8080.
- CMS: Strapi running on port 1337, with persistent volume cms-data.
 
Environment variables (REACT_APP_API_URL, REACT_APP_CMS_URL) ensure the frontend knows where to fetch data
## Run the stack
docker-compose up --build

- Frontend → http://localhost:3000
- Backend → http://localhost:8080/products
- CMS → http://localhost:1337


