import React, { useState, useEffect } from "react";
import axios from "axios";

const API = "http://localhost:8080";

function App() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [token, setToken] = useState(localStorage.getItem("token"));
  const [posts, setPosts] = useState([]);
  const [imageUrl, setImageUrl] = useState("");
  const [caption, setCaption] = useState("");

  // 🔐 LOGIN
  const login = async () => {
    try {
      const res = await axios.post(`${API}/api/auth/login`, {
        email,
        password
      });
      localStorage.setItem("token", res.data);
      setToken(res.data);
      alert("Login successful");
    } catch {
      alert("Invalid credentials");
    }
  };

  // 🖼️ CREATE POST
  const createPost = async () => {
    try {
      await axios.post(
        `${API}/api/posts/2`,
        null,
        {
          params: { imageUrl, caption }
        }
      );
      setImageUrl("");
      setCaption("");
      loadFeed();
    } catch {
      alert("Error creating post");
    }
  };

  // 📰 LOAD FEED
  const loadFeed = async () => {
    try {
      const res = await axios.get(`${API}/api/feed/2`);
      setPosts(res.data);
    } catch {
      console.log("Error loading feed");
    }
  };

  useEffect(() => {
    if (token) {
      loadFeed();
    }
  }, [token]);

  if (!token) {
    return (
      <div style={{ padding: 40 }}>
        <h2>Login</h2>
        <input
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        /><br/><br/>
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        /><br/><br/>
        <button onClick={login}>Login</button>
      </div>
    );
  }

  return (
    <div style={{ padding: 40 }}>
      <h2>Create Post</h2>
      <input
        placeholder="Image URL"
        value={imageUrl}
        onChange={(e) => setImageUrl(e.target.value)}
      /><br/><br/>
      <input
        placeholder="Caption"
        value={caption}
        onChange={(e) => setCaption(e.target.value)}
      /><br/><br/>
      <button onClick={createPost}>Post</button>

      <hr/>

      <h2>Feed</h2>
      {posts.map((post) => (
        <div key={post.id} style={{ marginBottom: 20 }}>
          <img src={post.imageUrl} alt="" width="200"/><br/>
          <b>{post.caption}</b>
        </div>
      ))}
    </div>
  );
}

export default App;
