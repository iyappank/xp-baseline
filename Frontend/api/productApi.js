import axios from "axios";
import { toast } from "react-toastify";

const BASE_URL = "http://localhost:8080";

export const fetchProducts = async () => {
  try {
    const response = await axios.get(`${BASE_URL}/products`);
    return response.data;
  } catch (error) {
    toast.error("Failed to load products");
    throw error;
  }
};