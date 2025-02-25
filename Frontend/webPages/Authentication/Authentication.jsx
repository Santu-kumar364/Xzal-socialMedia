import { Grid, Card } from "@mui/material";
import React from "react";
import Register from "./Register";
import Login from "./Login";

const Authentication = () => {
  return (
    <div>
      <Grid container>
        <Grid className="h-screen overflow-hidden" item xs={7}>
          <img
            className="h-full w-full object-cover"
            src="https://images.pexels.com/photos/268533/pexels-photo-268533.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
            alt="Authentication"
          />
        </Grid>
        <Grid item xs={5}>
          <div className="px-20 flex flex-col justify-center h-full ">
            <Card className="card p-8">
              <div className="flex flex-col items-center mb-5 space-y-1">
                <h1 className="log ">Xzal</h1>
                <p className="text-center text-sm w-[70]">
                  Connecting Lives, Sharing you're thoughts
                </p>
              </div>

              <Login/> 
              {/* <Register/>  */}
            </Card>

          </div>
        </Grid>
      </Grid>
    </div>
  );
};

export default Authentication;
