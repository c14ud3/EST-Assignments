# WeatherForecast

First, we created `testEmptyCityName` that tests that the function returns null if an empty string or null is provided as an input.
Since the mock setup of `WeatherApiService` and `CacheService` might be used in all future tests, their instantiation has been created in a `setup` function.
Then, `testCacheGetCalledEachTime` has been created to test that the function looks in the cache for every city.
Further, `testAPICalledOnlyIfNothingInCache` has been created to test, that the API is only called if nothing is found in cache.
Then, `testAPIDown` checks that the function throws a RuntimeException if the API is down.
And lastly, `testAPIworks` checks that the function returns the correct values with a mocked API.
