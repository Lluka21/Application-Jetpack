const express = require("express")

const app = express();

app.use(express.json());

app.post("/auth/signup", (req,res) => {
    const { username, email, password } = req.body;

    if(!username || !email || !password ) {
        return res.status(400).json({
            message: "All fields are required"
        })

    res.json({
        username: username,
        email: email,
        password: password
    });

    }
});

app.listen(3000,() => {
    console.log("Server is running on port 3000")
})