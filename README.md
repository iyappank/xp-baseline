# Experience Platform - Pilot version
Design and implement a modern frontend experience backed by a headless CMS and a microservice-based backend

# Application Architecture
<img width="985" height="414" alt="image" src="https://github.com/user-attachments/assets/8cfa5700-24dc-48d9-9f29-5c76f6dd5c30" />

   1. <b>Frontend SPA</b> - Node Js, React Js , NPX web server hosted in docker container 
   2. <b>Backend API Microservices</b> - JAVA Sprint Boot Services , hosted in docker containers with autoscaling.
   3. <b>Redis Cache</b> - Static data being cached into Redis Cache.
   4. <b>CMS - Sitecore XP JSS </b> Headless Services  APIs enables Content as Service, hosted in Docker containers with autoscaling as part of Sitecore Containers hosted platform.  
   5. <b>Azure CDN </b> Sitecore Headless API service responses are cached on Azure CDN </b> for improving performance on content delivery  
   6. <b>Azure APIM </b> Backend API as well as CDN URLs are added as Backend services in Azure API Management - It enables API Gateway with additonal security , scalability and performance.
   7. Frontend SPA application connects Azure APIM APIs. APIM APIs routes the traffic to Backend API.
      

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

## Frontend Design Considerations
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
<img width="312" height="485" alt="image" src="https://github.com/user-attachments/assets/a0e54044-f3b2-422b-b4f5-1cd5354f3766" />

## Dependencies 
* cd Frontend
* npm install 

## Run Locally
* cd Frontend
* npm run dev

Open browser at the URL shown - http://localhost:3000.

## Build for Production
* cd Frontend
* npm run build

This generates a dist/folder with optimized static files.

To preview:
npm run preview

# 2. Sitecore Headless CMS - Content Model

- <b>Page template</b> defines metadata and placeholders.
- <b>Banner template</b> defines reusable fields (Heading, Image, CTA).
- <b>Rendering definition</b> ties Banner to JSS.
- <b>Placeholder settings allow</b> authors to drag-and-drop Banner into Pages.
- <b>JSS Layout Service</b> exposes content for headless consumption.

## Page Template

Defines the structure of a page item.
- Template Name: Page
- Fields:
- Title (Single-Line Text)
- MetaDescription (Rich Text)
- Banner (Datasource reference to Banner component)
- Body (Rich Text or placeholder for child components)

## Banner Component Template

Reusable component for hero/banner sections.
- Template Name: Banner
- Fields:
- Title (Single-Line Text)
- Description (Single-Line Text)
- Image (Image field)
- CTA (General Link field)

## Rendering Definition

Defines how the Banner component is rendered in JSS.
- Rendering Item: /sitecore/layout/Renderings/Project/MySite/Banner
- Datasource Template: Banner
- Placeholder Key: banner
- Caching: Enabled (optional)

## Placeholder Settings

Controls which components can be dropped into placeholders.
- Placeholder Settings Item: /sitecore/layout/Placeholder Settings/banner
- Placeholder Key: banner
- Allowed Controls: Banner rendering (and optionally Hero, Carousel, etc.)
This ensures authors can drag-and-drop Banner components into the banner placeholder in Experience Editor/Horizon.

## Sitecore Feature Component 

<img width="251" height="333" alt="image" src="https://github.com/user-attachments/assets/6b283d4c-8798-4755-952d-c7f160bee7aa" />

## Exposing Content via JSS API

Layout Service (REST) Endpoint:
https://<<sitecore-host>>/sitecore/api/layout/render/jss?item=/home&sc_lang=en

# 3. Backend (SPA)

Minimalist Spring Boot microservice that serves an in-memory list of products via GET /products, includes OpenAPI/Swagger, error handling, and basic tests.

## Pre-requistics 

1. Visual Studio Code
2. Install VS Extension - **Extension Pack for Java**
3. Install VS Extension - **Maven for Java**
4. Download JDK - https://developers.redhat.com/products/openjdk/download
5. Extract and Copy to C:\Program Files\RedHat\java-21-openjdk-1.8
6. Download Maven Binary Zip from https://maven.apache.org/download.cgi#CurrentMaven
7. Extract and Copy to C:\Program Files\apache-maven-3.9.12
8. Add Two System Environment Variables as follows
   
   <img width="589" height="142" alt="image" src="https://github.com/user-attachments/assets/c5dd9f1b-9821-4308-ad58-80ca3cc407c6" />
10. Edit Path variable and include JDK and Maven bin folders.
    
   <img width="418" height="446" alt="image" src="https://github.com/user-attachments/assets/d2a1b524-4b5b-4e4a-a2d5-87c552a01da3" />

## Project structure

<img width="262" height="481" alt="image" src="https://github.com/user-attachments/assets/bfdf92b0-f37f-4ef5-81fe-095c246ce102" />


## How to run

* cd Backend

* Build: mvn clean package
* Run: mvn spring-boot:run
* API: GET http://localhost:8080/products
* Swagger UI: http://localhost:8080/swagger-ui.html
* OpenAPI JSON: http://localhost:8080/v3/api-docs

# 4. Containerization
- Single command starts the full stack.
- Clear separation of services.
- Reasonable ports: 3000 (frontend), 8080 (backend), 80 (CMS).

## Directory Layout 
<img width="669" height="165" alt="image" src="https://github.com/user-attachments/assets/cc17eef6-2cb5-4474-bfbd-97d4541af233" />

## How It Works
- Frontend: React app built and served via Nginx on port 3000.
- Backend: Spring Boot API exposed on port 8080.
 
Environment variables (REACT_APP_API_URL, REACT_APP_CMS_URL) ensure the frontend knows where to fetch data
## Run the stack
docker-compose up --build

- Frontend → http://localhost:3000
- Backend → http://localhost:8080/products
- CMS → http://localhost


