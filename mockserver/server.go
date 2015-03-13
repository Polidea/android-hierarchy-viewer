package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"

	"github.com/zenazn/goji/web"
)

const jsonFilename = "views.json"

type View struct {
	Name     string  `json:"name,omitempty"`
	Children *[]View `json:"children,omitempty"`
}

func HomeHandler(w http.ResponseWriter, r *http.Request) {
	http.ServeFile(w, r, "../webapp/index.html")
}

func ViewHandler(w http.ResponseWriter, r *http.Request) {
	view := View{}
	// you'd use a real database here
	file, err := ioutil.ReadFile(jsonFilename)
	if err != nil {
		log.Println("Error reading ", jsonFilename, " :", err)
		panic(err)
	}
	fmt.Printf("file: %s\n", string(file))
	err = json.Unmarshal(file, &view)
	if err != nil {
		log.Println("Error unmarshalling ", jsonFilename, " :", err)
	}

	bs, err := json.Marshal(view)
	if err != nil {
		ReturnError(w, err)
		return
	}
	fmt.Fprint(w, string(bs))
}

func ScreenHandler(w http.ResponseWriter, r *http.Request) {
	params := r.URL.Query()
	fmt.Println(params.Get("{path}"))
	fmt.Println(params.Get(":path"))
	fmt.Println(params.Get("path"))
}

func ReturnError(w http.ResponseWriter, err error) {
	fmt.Fprint(w, "{\"error\": \"%v\"}", err)
}

func main() {
	r := web.New()
	r.Get("/", HomeHandler)
	r.Get("/api/hierarchy", ViewHandler)
	r.Get("/api/screen/:path", ScreenHandler)
	http.Handle("/", r)
	http.ListenAndServe("localhost:3000", nil)
}
