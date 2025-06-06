import { createBrowserRouter } from "react-router-dom";
import { HomePage } from "../../pages/HomePage";
import { JobsPage } from "../../pages/JobsPage";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <HomePage />,
  },
  {
    path: "/jobs",
    element: <JobsPage />,
  },
]);
