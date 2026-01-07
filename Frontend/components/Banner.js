import React from "react";

const Banner = ({ title, description, image }) => (
  <div className="banner">
    <img src={image} alt={title} />
    <h1>{title}</h1>
    <p>{description}</p>
  </div>
);

export default Banner;
