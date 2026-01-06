// src/App.js
import React from "react";
import { BrowserRouter } from "react-router-dom";
import AppRoutes from "./routes";
import ErrorBoundary from "./components/ErrorBoundary";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const App = () => (
  <BrowserRouter>
    <ErrorBoundary>
      <AppRoutes />
      <ToastContainer position="top-right" autoClose={3000} hideProgressBar />
    </ErrorBoundary>
  </BrowserRouter>
);

export default App;