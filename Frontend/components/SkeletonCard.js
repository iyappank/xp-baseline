import React from "react";
import Skeleton from "react-loading-skeleton";
import "react-loading-skeleton/dist/skeleton.css";

const SkeletonCard = () => (
  <div className="product-card">
    <Skeleton height={30} width={200} />
    <Skeleton count={2} />
    <Skeleton height={20} width={100} />
  </div>
);

export default SkeletonCard;