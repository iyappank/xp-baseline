import React from "react";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Products from "./pages/Products";
import Layout from "./components/Layout";

const AppRoutes = () => (
  <Layout>
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/products" element={<Products />} />
    </Routes>
  </Layout>
);

export default AppRoutes;