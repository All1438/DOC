let n = 0

function render(){
    const title = React.createElement("h2", {},
    "Suis-je le Bienvenue ",
    React.createElement("span", {}, n) // permet de creer un élément ("balise", {attribut}, "enfants ou elementReact", "enfants")
    )  
    ReactDOM.render(title, document.querySelector("#app")) // permet d'afficher (ElementReact, document.placement)
}

function numberFormat(n){
    return n.toString().padStart(2, "0")
}

function renderJSX(){
    const items = [
        "items1",
        "items2",
        "items3"
    ]
    const k = [1, 2, 3]
    const lis = items.map((item, k) => <li key={k.toString()} >{item}</li>)
    const title = <React.Fragment><h1 id="title" className="title"> 
        Je n'abondonnerai jamais <span>{n % 2 ? numberFormat(n) : null}</span> 
        </h1> 
        <ul>{lis}</ul>
        </React.Fragment>
        // balise<React.Fragment> = permet de faire une balise vide(crée un élément qui n'a pas de racine définie) car un variable doit contenir un element
        // toujours mettre l'attribut key="" pour mieux identifier les listes
        // utiliser l'attribute className au lieu de class
        // { } = permet de mettre les valeur qui sera evalué et qui sera rendue (même function, condition)
    ReactDOM.render(title, document.querySelector("#app1"))
}
renderJSX()

setInterval(() => {
    n++
   renderJSX()
}, 1000)

function WelcomeFunc(props){ // les propriété sera mis dans une {name, children}. name = attribut, children = enfant
    console.log(props)
    return <div>
        <h1>Salutation {props.name} </h1> {/*commentaire dans JSX*/}
        <p>{props.children} </p>
    </div>
}

class Welcome extends React.Component{ // React.Component = pour définir un composant React avec une classe
    // extends = signifier qu'un type représenté par une classe hérite d'un autre type
    render(){
        return <div>
        <h1>Salutation {this.props.name} </h1> {/*commentaire dans JSX*/}
        <p>{this.props.children} </p> {/*props est reconu automatiquement sans l'aide du constructor()*/}
    </div>
    }
}

class Clock extends React.Component{
    constructor(props){
        super(props) // super() = il est indispensable pour l'utilisation des parents
        this.state = {date: new Date()} // this.state = (objet propriété spécifique) est utilisé lorsque les données qui lui sont associées évolue dans le temps
        this.timer = null
    }
    componentDidMount(){ // permet de déterminer quand un composant a été monté
        this.timer = window.setInterval((this.tick.bind(this)) , 1000) // bind = crée une nouvelle fonction qui a pour context this
    }
    componentWillUnmount(){ // permet de déterminer quand un composant a été supprimer
        window.clearInterval(this.timer)
    }
    tick(){
        this.setState({date: new Date()}) // setState(changement) = permet de changer le state d'un composante
    }
    render(){
        return <div>
            il est {this.state.date.toLocaleDateString()} {this.state.date.toLocaleTimeString()}
        </div>
    }
}

class Incrementer extends React.Component{
    constructor(props){
        super(props)
        this.state = {n: props.start, timer: null}
        this.toggle = this.toggle.bind(this) // pour obtimiser le function render() car il sera appelé tout les secondes
        this.label = this.label.bind(this)
    }
    componentDidMount(){
        this.play()
    }
    conponentWillUnmount(){
        window.clearInterval(this.state.timer) // dans le conponentWillUnmount() doit comporter seulement la suppression du composante
    }
    increment(){
        this.setState(function(state, props){ // a utilisé ce function si il y a 2 state consécutives (setState et this.state) ou utilisation d'un props
            return {n: this.state.n + props.step} // si il y a propriété step il sera incrémenté de "10" en "10" sinon "1" car step: 1 
        })
    }
    pause(){
        window.clearInterval(this.state.timer)
        this.setState({
            timer: null
        })
    }
    play(){
        this.setState({
            timer: setInterval(this.increment.bind(this), 1000)
        })
    }
    toggle(){
        return this.state.timer ? this.pause() : this.play()
    }
    label(){
        return this.state.timer ? "Pause" : "Lecture"
    } 
    reset(){
        this.pause()
        this.play()
        this.setState((state, props) => ({n: props.start}))
    }
    /* render(){
        return <div>
            Valeur : {this.state.n}
            {this.state.timer ? // condition if
            <button onClick={this.pause.bind(this)}>Pause</button> :
            <button onClick={this.play.bind(this)}>Lecture</button>}    //si on click plusieur fois sur lecture, il y aura une bug car l'ancien timer n'est pas effacer
            </div> 
    }*/
    render(){
        return <div>
            Valeur : {this.state.n}
            <button onClick={this.toggle.bind}>{this.label()}</button> {/*onClick = a chaque fois qu'on click sur le button, cette evenement sera declancher */}
            <button onClick={this.reset.bind}>Reinitialiser</button>
        </div>
    }
}
Incrementer.defaultProps = { // .defaultProps = = permet de définir les valeurs par défaut de props pour cette classe
    start: 0,
    step: 1
}

class ManualIncrementer extends React.Component{
    constructor(props){
        super(props)
        this.state = {n: 0}
    }
    increment(){
        this.setState((state, props) => ({n: state.n + 1}))
    }
    render(){
        return <div> Valeur: {this.state.n}<button onClick={this.increment.bind(this)}>Incrementer</button> </div>
    }
}
        // Formulaire {base}
class Formulaire extends React.Component{
    constructor(props){ // ce n'est pas une bonne façon de faire
        super(props)
        this.state = {nom: "Ali Nando", 
                        anarana:"nothing", 
                        name:["demo2, demo1"],
                        checked: true} // true = activer
        this.texte = this.texte.bind(this)
        this.textarea = this.textarea.bind(this)
        this.select = this.select.bind(this)
        this.checkbox = this.checkbox.bind(this)

    }
    checkbox(e){
        this.setState({checked: e.target.checked})
    }
    texte(e){ // e = evenement
        this.setState({nom: e.target.value}) // target = permet de recuperer le champ et value = permet de recuperer la valeur
    }
    textarea(e){
        this.setState({anarana: e.target.value})
    }
    select(e){
        this.setState({name: Array.from(e.target.selectedOptions).map(o => o.value)}) // .selectedOptions = recupère les options séléctionner
    }
    render(){
        return <div>
            <label htmlFor="nom">Mon nom</label> {/*htmlFor = On ecrit de cette façon car for est un mot clé du JavaScript*/}
            <input type="texte" id="nom" name="nom"  value={this.state.nom} onChange={this.texte}/> {/*dans le JSX les balises doit avoir une version fermante ou auto fermante*/} <br/><br/>
            <label htmlFor="commentaire">Commentaire: </label> <br/>
            <textarea type="texte" name="commentaire" id="commentaire" value={this.state.anarana} onChange={this.textarea}></textarea> {/* la valeur du textarea aussie sera dans l'attribut mais pas dans l'enfant(children) */} <br/><br/>
            <select value={this.state.name} onChange={this.select} multiple> {/*multiple = permet de faire une choix multiple */}
                <option value="demo1">demo 1</option>
                <option value="demo2">demo 2</option>
                <option value="demo3">demo 3</option>
            </select>
            {JSON.stringify(this.state.name)} <br/><br/> {/*JSON.stringify() = convertie la valeur JS en chaine JSON*/}
            <label>la réussite </label>
            <input type="checkbox" checked={this.state.checked} onChange={this.checkbox}/> {/*type= checkbox on utilise checked mais pas value*/}
            {this.state.checked ? <div>Un message afficher si on coche sur checkbox</div> : null}
            <label htmlFor="champ">Champ qui n'est pas controler par react</label>
            <input type="text" defaultValue="no React"/> {/*champ qui n'est pas controler par react car on n'a pas définie son value*/}
        </div>
    }
}
        // formulaire {ecriture}
function Field({name, value, onChange, children}) {
    return <div className="form-group">
        <label htmlFor={name}>{children}</label>
        <input type="texte" value={value} onChange={onChange} id={name} name={name} className="form-control" />
    </div>
}
function Checkbox({name, value, onChange, children}) {
    return <div className="form-checked">
        <input type="checkbox" checked={value} onChange={onChange} id={name} name={name} className="form-check-input"/>
        <label htmlFor={name} className="form-check-label">{children}</label>
    </div>
}
class NewFormulaire extends React.Component{
    constructor(props){ // la bonne façon de faire
        super(props)
        this.state = {nom:" ",
                        prenom: " ",
                        newLetter: false}
        this.handleChange = this.handleChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
    }
    handleChange(e){
        const name = e.target.name
        const type = e.target.type
        const value = type === "checkbox" ? e.target.checked : e.target.value
        this.setState({
            [name]: value
        })
    }
    handleSubmit(e){
        e.preventDefault() // preventDefault() = pour empêcher la comportement par defaut si l'action est executer (utiliser pour les button)
        e.target.reset() // target.reset() = permet de supprimer les contenu du formulaire après le submit
        const data = JSON.stringify(this.state)
        console.log(data)
        this.setState({
            nom:" ",
            prenom: " ",
            newLetter: false
        })
    }
    render(){
        return <form className="container" onSubmit={this.handleSubmit}> {/*onSubmit = execute si on click sur le button submit */}
            <Field name="nom" value={this.state.nom} onChange={this.handleChange}>Nom:</Field> {/*le name doit être le même de que emailjs */}
            <Field name="prenom" value={this.state.prenom} onChange={this.handleChange}>Prenom:</Field>
            <Checkbox name="newLetter" checked={this.state.newLetter} onChange={this.handleChange}>S'abonné</Checkbox>
            <div className="form-group">
            <button className="btn btn-success">Envoyer</button>
            </div>
        </form>
    }
}
        // convertisseur Celsius / Fahrenheit*
function BoilingVerdict({celsius}){
    if(celsius >= 100){
        return <div className="alert alert-success">l'eau bout</div>
    }
    return <div className="alert alert-info">l'eau ne bout pas</div>
}

ReactDOM.render(<Welcome name="Ali Nando">Je serai le Roi</Welcome>, document.querySelector("#app2"));{/* </> = permet d'insérer des propriété, le tag du function devra toujours commencé par une Majuscule, afficher auto sans appelation du function */}

function Home(){
    return <div>
        <Welcome name="Ali">coté amusant</Welcome>
        <Welcome name="Nando">coté travailleur</Welcome>
        <Clock/>
        <Incrementer start={10}/>
        <Incrementer start={100} step={10}/>
        <ManualIncrementer/>
        <Formulaire/>
        <NewFormulaire/>
    </div>
}
ReactDOM.render(<Home/>, document.querySelector("#app2"))
ReactDOM.render(<BoilingVerdict celsius={50}/>, document.querySelector("#app3"))

    // installation react:
// Il faut installer node Js pour installer react
// npx create-react-app nom-react = la commande qui permet de créer react est le nom-react ne doit pas être en majuscule est séparer d'un -
// npm start = permet de lancer le go live dans le "localhost: 3000"
// npm run build = permet de générer les fichiers static
// npm test = permet de lancer le test
// npm install react-icons --save = permet de telecharger les icons dans react (site:react-icons)
// npm install swiper = permet de telecharger les slid dans react (site:swiperjs)
// npm install emailjs-com --save = permet de relier avec le code avec l'E-mail (react emailjs)

    // parcel react:
// npm init -y = permet d'initialiser le fichier package.JSON
// npm add react react-dom = permet d'ajouter des packages react et react-dom dans le project
// npm add -D parcel-bundler = permet d'installer parcel
// npx parcel fichier_d'entrer = permet de lancer le go live dans le "localhost: 1234" après avoir installer parcel, fichier d'entrer(index.html)
//pour publier l'application react: 
    // -supprimer le dossier dist
    // -npx parcel build fichier_d'enter = permet de minifier les codes dans un dossier dist

