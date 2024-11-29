import React from 'react'

const scaleNames = {
    c: "celsius",
    f: "fahrenheit"
}
/**
 * T(°C) = (T(°F) - 32) x 5/9
 * T(°F) = T(°C) x 9/5 + 32
 */
function toCelsius (fahrenheit){
    return (fahrenheit - 32) * 5/9
}
function toFahrenheit (celsius){
    return celsius * 9/5 + 32
}
function tryConvert (temperature, convert){
    const value = parseFloat(temperature)
    if(Number.isNaN(value)){
        return '';
    }
    return (Math.round(convert(value) * 100) / 100).toString() // faire une deux chiffre après la virgule 0.00
}

function BoilingVerdict ({celsius}){
    if(celsius >= 100){
        return <div className="alert alert-success mt-4">L'eau bout</div>
    }
    return <div className="alert alert-info mt-4">L'eau ne bout pas</div>
}

function Button({type, children}) { // la composition dans react
    const className = "btn btn-" + type
    return <button className={className}>{children}</button>
}

function Column2({left, right}) { // composition 
    return <div className="row">
        <div className="col-md-6">{left}</div>
        <div className="col-md-6">{right}</div>
    </div>
}

class TemperatureInput extends React.Component{
    constructor(props){
        super(props)
        this.handleChange = this.handleChange.bind(this)
    }
    handleChange(e){
        this.props.onTemperatureChange(e.target.value)
    }
     render(){
        const {temperature} = this.props
        const name = "scale" + this.props.scale // pour differencier le name
        const scaleName = scaleNames[this.props.scale]
        return <div className="form-group">
                <label htmlFor={name} classeName="form-label">Temperature (en {scaleName})</label>
                <input type="text" value={temperature} id={name} className="form-control" onChange={this.handleChange}/>
            </div>
     }
}

class Calculator extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            temperature: 20,
            scale: 'c'
        }
        this.handleCelsiusChange = this.handleCelsiusChange.bind(this)
        this.handleFahrenheitChange = this.handleFahrenheitChange.bind(this)
    }
    handleCelsiusChange (temperature){
        this.setState({
            scale: 'c',
            temperature
        })
     }
    handleFahrenheitChange (temperature){
        this.setState({
            scale: 'f',
            temperature
        })
    }
}
    



const Conversion = () => {
  return (
    <div>
        <div>
            <Column2 
            left={<TemperatureInput scale="c" temperature={celsius} onTemperatureChange={this.handleCelsiusChange}/>} //on peut mettre un composant dans ...
            right={<TemperatureInput scale="f" temperature={fahrenheit} onTemperatureChange={this.handleFahrenheitChange}/>}
            />
            <BoilingVerdict celsius={celsius}/> {/*convertion en float la chaine de caractère */}
            <Button type="primary">Envoyer</Button>
      </div>
    </div>
  )
}

export default Conversion