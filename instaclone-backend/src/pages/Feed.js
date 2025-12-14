import { useEffect, useState } from "react";
import API from "../api/api";

export default function Feed() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    API.get("/feed/2") // logged-in user id
      .then((res) => setPosts(res.data))
      .catch(() => alert("Error loading feed"));
  }, []);

  return (
    <div>
      <h2>Feed</h2>
      {posts.map((p) => (
        <div key={p.id}>
          <img src={p.imageUrl} width="200" alt="" />
          <p>{p.caption}</p>
        </div>
      ))}
    </div>
  );
}
