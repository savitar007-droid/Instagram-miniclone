import { useState } from "react";
import API from "../api/api";

export default function CreatePost() {
  const [imageUrl, setImageUrl] = useState("");
  const [caption, setCaption] = useState("");

  const submit = async (e) => {
    e.preventDefault();
    const userId = 2; // change based on logged-in user

    try {
      await API.post(`/posts/${userId}`, null, {
        params: { imageUrl, caption },
      });
      alert("Post created");
    } catch {
      alert("Error creating post");
    }
  };

  return (
    <form onSubmit={submit}>
      <h2>Create Post</h2>

      <input
        placeholder="Image URL"
        onChange={(e) => setImageUrl(e.target.value)}
      />
      <input
        placeholder="Caption"
        onChange={(e) => setCaption(e.target.value)}
      />

      <button>Create</button>
    </form>
  );
}
