export default class HttpRequest {
	static async get(url) {
		const method = 'GET';
		const res = await HttpRequest.#send(method, url);
		
		return res.data;
	}
	
	static async post(url, data) {
		const method = 'POST';
		const res = await HttpRequest.#send(method, url, data);

		console.log(res);

		if (res.count > 0) {
			return res.data;
		} else {
			throw Error(res.message);
		}
	}
	
	static async patch(url, data) {
		const method = 'PATCH';
		const res = await HttpRequest.#send(method, url, data);
		
		if (res.count > 0) {
			return res.data;
		} else {
			throw Error(res.message);
		}
	}
	
	static async put(url, data) {
		const method = 'PUT';
		const res = await HttpRequest.#send(method, url, data);
		
		if (res.count > 0) {
			return res.data;
		} else {
			throw Error(res.message);
		}
	}
	
	static async delete(url, data) {
		const method = 'DELETE';
		const res = await HttpRequest.#send(method, url, data);
		
		if (res.count > 0) {
			return res.data;
		} else {
			throw Error(res.message);
		}
	}
	
	static async #send(method, url, data) {
		
		const sendOption = {
			method : method,
			headers : {
	            'Content-Type': 'application/json'
	        },
			body : JSON.stringify(data)
		};
		
		return fetch(url, sendOption);
	}

}