import React, { useState } from "react"
import Heading from "../../common/Heading"
import "./hero.css"

const Hero = () => {

  const [area, setArea] = useState('');
  const [city, setCity] = useState('');
  const [propertyType, setPropertyType] = useState('');
  const [priceRange, setPriceRange] = useState('');

  const propertyTypes = ['House', 'Apartment', 'Condo', 'Land'];
  const location = ['Pune', 'Mumbai'];
  const areas = ['Pashan','Aundh'];
  const prices = [
    {
      value: "100000 - 130000",
    },
    {
      value: '130000 - 160000',
    },
    {
      value: '160000 - 190000',
    },
    {
      value: '190000 - 220000',
    },
    {
      value: '10000 - 30000',
    },
    {
      value: '30000 - 40000',
    },
  ];

  const handleAreaChange = (event) => setArea(event.target.value);
  const handleCityChange = (event) => setCity(event.target.value);
  const handlePropertyTypeSelect = (selectedType) => setPropertyType(selectedType);
  const handlePriceRangeSelect = (selectedRange) => setPriceRange(selectedRange);

  return (
    <>
      <section className='hero'>
        <div className='container'>
          <Heading title='Search Your Next Home ' subtitle='Find new & featured property located in your local city.' />

          <form className='flex'>
            <div className='box'>
              <span>City</span>
              <select
                value={city}
                onChange={(e) => handleCityChange(e.target.value)}
              >
                {location.map((city, index) => (
                  <option key={index} value={city}>
                    {city}
                  </option>
                ))}
              </select>
            </div>
            <div className='box'>
              <span>Area</span>
              <select
                value={area}
                onChange={(e) => handleAreaChange(e.target.value)}
              >
                {areas.map((area, index) => (
                  <option key={index} value={area}>
                    {area}
                  </option>
                ))}
              </select>
            </div>
            <div className='box'>
              <span>Property Type</span>
              <select
                value={propertyType}
                onChange={(e) => handlePropertyTypeSelect(e.target.value)}
              >
                {propertyTypes.map((property, index) => (
                  <option key={index} value={property}>
                    {property}
                  </option>
                ))}
              </select>
            </div>
            
            <div className='box'>
              <span>Price Range</span>
              <select
                value={priceRange}
                onChange={(e) => handlePriceRangeSelect(e.target.value)}
              >
                {prices.map((price, index) => (
                  <option key={index} value={price.value}>
                    {price.value}
                  </option>
                ))}
              </select>
            </div>
            <button className='btn1'>
              <i className='fa fa-search'></i>
            </button>
          </form>
        </div>
      </section>
    </>
  )
}

export default Hero
