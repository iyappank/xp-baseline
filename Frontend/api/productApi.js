import axios from "axios";
import { toast } from "react-toastify";

const BACKEND_API_URL = import.meta.env.REACT_APP_API_URL ? import.meta.env.REACT_APP_API_URL :  "http://localhost:8080";

export const fetchProducts = async () => {
  try {
    const response = await axios.get(`${BACKEND_API_URL}/products`);
    return response.data;
  } catch (error) {
    toast.error("Failed to load products");
    throw error;
  }
};