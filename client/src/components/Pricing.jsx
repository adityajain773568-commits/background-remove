import React from "react";
import { plans } from "../assets/assets";
const Pricing = () => {
  return (
    <div className="py-10 ">
      {/* Pricing header */}
      <div className="mb-16 flex flex-col ">
        <h2 className=" text-3xl text-center font-bold md:text-4xl mb-10">
          Choose your perfect package
        </h2>
        <p className="text-center max-w-2xl items-center mx-auto">
          Select from our carefully curated photography packages designed to
          meet your specific needs and budget.
        </p>
      </div>

      <div className="mb-16 grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8 justify-center items-center ml-12 ">
        {plans.map((plan) => (
          <div
            key={plan.id}
            className="relative w-72 bg-gray-900 text-white rounded-2xl p-6 shadow-lg text-center h-80 hover:scale-110 hover:delay-5 hover:transform-3d">
            {/* Badge */}
            {plan.popular && (
              <div className="absolute -top-4 left-1/2 -translate-x-1/2">
                <span className="bg-linear-to-r from-purple-500 to-indigo-500 text-white text-sm px-4 py-1 rounded-full shadow-md">
                  Most Popular
                </span>
              </div>
            )}

            <h2 className="text-xl font-semibold mb-2 mt-4">{plan.name}</h2>

            <p className="text-3xl font-bold text-purple-400 mb-4">
              ₹{plan.price}
            </p>

            <p className="text-gray-400 mb-2">{plan.credits}</p>

            <p className="text-gray-400 mb-6">{plan.description}</p>

            <button className="w-full py-2 rounded-full bg-linear-to-r from-purple-500 to-indigo-500 font-medium hover:from-indigo-600 hover:to-purple-600 hover:opacity-90 transition cursor-pointer">
              Choose plan
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Pricing;
