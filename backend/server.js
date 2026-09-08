const express = require("express")

const app = express();

app.get("/test",(req, res) => {
    res.json({
    message: "Backend is working!"
    });
})

app.post("/test",(req,res) => {
    res.json({
        message: "POST is working"
    })
})


app.listen(3000,() => {
    console.log("Server is running on port 3000")
})