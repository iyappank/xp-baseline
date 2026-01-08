import React, { useEffect, useState } from "react";
import { fetchCMSContent } from "../api/cmsApi";
import Banner from "../components/Banner";
import Skeleton from "react-loading-skeleton";

const Home = () => {
  const [content, setContent] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchCMSContent()
      .then(setContent)
      .catch((err) => console.error(err))
      .finally(() => setLoading(false));
  }, []);

  if (loading) {
    return (
      <div style={{ padding: "2rem" }}>
        <Skeleton height={200} />
        <Skeleton height={40} width={300} />
        <Skeleton count={3} />
      </div>
    );
  }

  if (!content) return <p>Error loading content.</p>;

  return (
    <Banner
      title={content.title}
      description={content.description}
      image={content.bannerImage}
    />
  );
};

export default Home;