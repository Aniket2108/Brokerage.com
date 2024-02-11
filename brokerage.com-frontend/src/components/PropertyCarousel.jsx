import React, { useContext } from 'react'
import Carousel from "react-multi-carousel";
import "react-multi-carousel/lib/styles.css";
import { HouseContext } from './HouseContext';
import {ImSpinner2} from 'react-icons/im'
import House from './House';
import { Link } from 'react-router-dom';

const PropertyCarousel = () => {
    const {houses,loading} = useContext(HouseContext);
  if(loading){
    return (<ImSpinner2 className='mx-auto animate-spin text-violet-700 text-4xl mt[200px]'/>)
  }
  if(houses.length === 0){
    return <div className='text-center text-3xl text-gray-400 mt-48'><p>Sorry,No houses found</p></div>
  }

    const responsive = {
        superLargeDesktop: {
            // the naming can be any, depends on you.
            breakpoint: { max: 4000, min: 3000 },
            items: 5
        },
        desktop: {
            breakpoint: { max: 3000, min: 1024 },
            items: 3
        },
        tablet: {
            breakpoint: { max: 1024, min: 464 },
            items: 2
        },
        mobile: {
            breakpoint: { max: 464, min: 0 },
            items: 1
        }
    };
    return (
        <section className='className=mb-20'>
            {/* <div className='bg-violet-100'> */}
            <Carousel responsive={responsive} className=''>
            {houses.map((house,index)=>{
      return (
        <div className='mt-10 mb-10 '>
        <Link to={`/property/${house.id}`} key={index}>
          <House house={house}></House>
        </Link>
        </div>
        
      )})}
            </Carousel>;

        {/* </div> */}
        </section>
    )
}

export default PropertyCarousel




