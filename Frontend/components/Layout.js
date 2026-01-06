// src/components/Layout.js
import React from "react";
import { Link } from "react-router-dom";

const Layout = ({ children }) => (
  <div>
    <nav>
      <Link to="/">Home</Link> | <Link to="/products">Products</Link>
    </nav>
    <main>{children}</main>
  </div>
);

export default Layout;
