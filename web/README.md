# WEB on Next.js

## Dependency

### Init Next App

```bash
APP_NAME=web
npx create-next-app $APP_NAME --use-npm
```

### Install dependency

- [TypeScript](https://medium.com/@selvaganesh93/setup-next-js-with-typescript-integration-dece94e43cf5)

  ```bash
  npm install @zeit/next-typescript @types/next @types/react
  ```
  
  ```javascript
  // in next.config.js
  const withTypescript = require('@zeit/next-typescript')
  module.exports = withTypescript({
    webpack(config, options) {
      return config
    }
  })
  ```
  
  ```json
  // in .babelrc
  {
  "presets": ["next/babel", "@zeit/next-typescript/babel"]
  }
  ```
